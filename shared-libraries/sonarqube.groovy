// Sciflare - D11 - MM
// This is for the Java build - REST API

def call(String sonarQubeProjectKey, String sonarScannerHome = 'sonar-scanner') {
    withSonarQubeEnv('SonarQube') {
        sh """
            ${sonarScannerHome}/bin/sonar-scanner \
                -Dsonar.projectKey=${sonarQubeProjectKey} \
                -Dsonar.sources=src \
                -Dsonar.host.url=http://sonarqube:9000
        """
    }
    echo "SonarQube analysis completed."
}
