def x = 4
organization = "organization"
libraries{
    tenant_lib{
        repo = "whatever"
    }
    maven{
        cmd = "mvn -v" 
    }
}
use_pipeline_template{
    name = "frontend" 
}
