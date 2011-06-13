@Grab(group='org.jruby', module='jruby-complete', version='1.5.6')

import org.jruby.Main as JRuby

scriptEnv = "test"
includeTargets << grailsScript("_GrailsTest")

def gemsDir = new File("./target/gems")

def gemsToInstall = { gems ->
    def installedGems = new File("$gemsDir/gems").listFiles().toString()
    gems.findAll { gem -> !installedGems.contains(gem) }
}

def jruby = { command -> 
    new JRuby().run command.split()
}

target(installgems: "Setup the environment for cucumber & friends") {
    def gems = ['cucumber']
    if (buildConfig.gems) gems.addAll( buildConfig.gems )
    
    gems = gemsToInstall( gems )
    if ( gems ) {
        println "Cucumber: installing gems $gems"
        jruby "-S jgem install -i $gemsDir --no-rdoc --no-ri ${gems.join(' ')}"
    }
}

target(cuke: "Run through the features ") {
    depends( installgems )
    functionalTestPhasePreparation()
    
    mkdir( dir: 'target/test-reports/html' )
    jruby "-S $gemsDir/bin/cucumber test/features --format html --out target/test-reports/html/cucumber.html --format pretty"
    
    functionalTestPhaseCleanUp()
}

setDefaultTarget("cuke")
