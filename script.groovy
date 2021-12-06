def deployApp()
{
    build job: 'App';
}
def CopyAppToAutomation()
{

    
}

def BDD_Parallel_FluentWaitCode_Sibling()
{
    sh "mvn verify"
}


return this