import sdp.SerializableConfigSlurper
node {  
  checkout scm
  
  println "---------------"
  println "SDP PIPELINE CONFIG: 
  sdp = new SerializableConfigSlurper().parse(libraryResource("sdp/pipeline_config.groovy"))
  println sdp.prettyPrint()
  
  println "--------------"
  println "TENANT PIPELINE CONFIG: "
  tenant = new SerializableConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  if (!tenant.organization) error "Organization specification required." 
  library tenant.organization
  println tenant.prettyPrint()
  
  println "--------------"
  println "ORGANIZATION PIPELINE CONFIG: "
  organization = get_organization_configuration()
  println organization.prettyPrint()
  
}
