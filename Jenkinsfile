
node {  
  checkout scm
  
  println readFile("pipeline_config.groovy")
  tenant = new ConfigSlurper().parse(readFile("pipeline_config.groovy"))
  println tenant.prettyPrint()
  
}
