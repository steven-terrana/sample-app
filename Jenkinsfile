
node {  
  checkout scm
  
  println readFile("pipeline_config.groovy")
  tenant = new ConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  println tenant.prettyPrint()
  
}

@NonCPS
def parse_config(){
  def tenant = new ConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  println "tenant: "
  println tenant.prettyPrint()
  return tenant
}
