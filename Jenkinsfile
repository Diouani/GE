pipeline {
    agent {
        docker { image 'maven:3.3.3' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean install'
            }
        }
    }
}
