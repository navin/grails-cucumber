class CucumberGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.4 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Grails Cucumber Plugin" // Headline display name of the plugin
    def author = "James Wolstenholme"
    def authorEmail = "j@meswolstenholme.com"
    def description = '''\
https://github.com/jwolstenholme/grails-cucumber
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/cucumber"

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/jwolstenholme/grails-cucumber" ]

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }
}
