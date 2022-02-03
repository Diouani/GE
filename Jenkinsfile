pipeline {
    agent {
        docker { image 'maven:3.8.4-openjdk-11-slim' }
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

