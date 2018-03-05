import sdp.SerializableConfigSlurper
node {  
  checkout scm
  
 
  sdp = new SerializableConfigSlurper().parse(libraryResource("sdp/pipeline_config.groovy"))
  
  tenant = new SerializableConfigSlurper().parse(readFile("pipeline_config.groovy")) 
  if (!tenant.organization) error "Organization specification required." 
  library tenant.organization
  
  organization = get_organization_configuration()
 
  

  pipeline_config = tenant + sdp + organization

  def getProp = { o , p ->
    if (!p) return
    return p.tokenize('.').inject(o){ obj, prop ->       
      obj[prop]
    }
  }

  def clearProp = { o , p ->
    if (!p) return  
    last_token = p.tokenize('.').last()
    return p.tokenize('.').inject(o){ obj, prop ->
        if (prop.equals(last_token)) obj[prop] = [:]
        obj[prop]         
    }
  }

  organization.flatten().findAll{ it.key.endsWith(".overridable") && it.value.equals(true) }.each{ key, value ->
    def k = key - ".overridable"
    if(getProp(tenant, k)){
      clearProp(pipeline_config, k)
      // << works
      getProp(pipeline_config, k).entrySet().each{ it.remove() }.merge(getProp(tenant, k))
    }
  }
  
  println """
-------------------
| SDP 
-------------------
${sdp.prettyPrint()}
-------------------
| ORGANIZATION
-------------------
${organization.prettyPrint()}
-------------------
| TENANT
-------------------
${tenant.prettyPrint()}
-------------------
| AGGREGATED CONFIG
-------------------
${pipeline_config.prettyPrint()}
"""
  

  
}
