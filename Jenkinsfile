pipeline {
    agent {
        docker { image 'maven:3.8.4' }
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

