organization = "organization"

use_pipeline_template{
    
}

application_environments{
    dev{
        bananas = 6
        short_name = "tenant dev"
    }
    test{
        short_name = "tenant_test"
        long_name = "Tenant Test"
    }
    staging{
        short_name = "Tenant Staging"
        long_name = "Tenant Staging"
        bananas = 12
    }
}

libraries{
    docker{ 
        branch = "testing" 
    }
}
