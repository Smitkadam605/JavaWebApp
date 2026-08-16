pipeline {

    agent any

    tools {
        jdk 'JDK25'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building Java application...'
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Creating WAR file...'
                bat 'mvn package -DskipTests'
            }
        }

        stage('Archive') {
            steps {
                echo 'Archiving WAR file...'
                archiveArtifacts artifacts: 'target/*.war',
                                 fingerprint: true
            }
        }
    }

    post {

        success {
            echo '===================================='
            echo 'BUILD SUCCESSFUL'
            echo 'JavaWebApp pipeline completed.'
            echo '===================================='
        }

        failure {
            echo '===================================='
            echo 'BUILD FAILED'
            echo 'Check the Jenkins console output.'
            echo '===================================='
        }

        always {
            echo 'Pipeline execution finished.'
        }
    }
}