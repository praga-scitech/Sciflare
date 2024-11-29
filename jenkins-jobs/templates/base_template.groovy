pipelineJob('base-pipeline-job') {
    description('Pipeline job using shared libraries and variables')

    // Define environment variables that will be used in the pipeline
    environmentVariables {
        env('MY_VAR', 'some-value') // A simple variable
        env('BUILD_VERSION', '1.0.0') // A build version variable
        env('git_url', 'https://github.com/your-org/your-repo.git')
        env('git_branch', 'main')
    }

    // Define the pipeline definition
    definition {
        cpsScm {
            scm {
                // Using Git repository for the Jenkinsfile
                git( ${git_url}, ${git_branch} ) {
                    // Set the path to the Jenkinsfile within the repository
                    branch('main')
                    scriptPath('Jenkinsfile')  // Path to the Jenkinsfile in the repo
                }
            }

            // Use a specific shared library here
            libraries {
                library('your-shared-library') // The name of the shared library
            }
        }
    }
}
