node {  
  checkout scm
  
  tenant = new ConfigSlurper.parse(readFile("pipeline_config.groovy"))
  println tenant.prettyPrint()
  
}
