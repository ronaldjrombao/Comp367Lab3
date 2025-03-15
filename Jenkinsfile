pipeline {
    agent any

    tools {
        maven "M3"
    }

    environment {
        GIT_REPO = 'git@github.com:ronaldjrombao/Comp367Lab3.git'
        BRANCH = 'master'
        DOCKERHUB_CREDENTIALS = credentials('DockerHubCreds')
        DOCKER_IMAGE = 'ronaldjrombao/comp367lab3'
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository using SSH...'
                git branch: "${BRANCH}", url: "${GIT_REPO}", credentialsId: 'GithubSSh'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

    }

    post {
        success {
            echo 'Build successful!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}