pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                bat 'mvn --version'
                bat 'mvn clean install'
            }
        }
    }
}

