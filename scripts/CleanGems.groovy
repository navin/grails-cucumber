target(cleangems: "Remove all installed gems") {
    delete ( dir: 'target/gems' )
}

setDefaultTarget("cleangems")
