organization = "organization"
application_environments{
    tenant_only{
        name = "whatever"
    }
}
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
