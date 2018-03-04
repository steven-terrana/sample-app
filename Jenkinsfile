
node {  
  checkout scm
  
  println readFile("pipeline_config.groovy")
  tenant = parse_config()
  println tenant.prettyPrint()
  
}

@NonCPS
def parse_config(){
  new ConfigSlurper().parse(readFile("pipeline_config.groovy")) as HashMap
}
