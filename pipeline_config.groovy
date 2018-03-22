import groovy.json.JsonSlurper
def j = new JsonSlurper()

organization = "organization"
libraries{
    tenant_lib{
        repo = "whatever"
    }
    maven{
        cmd = "mvn -v" 
    }
}
