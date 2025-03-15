pipeline {
    agent { dockerfile true }

    environment {
        GIT_REPO = 'git@github.com:ronaldjrombao/Comp367Lab3.git'
        BRANCH = 'master'
        DOCKERHUB_CREDENTIALS = credentials('DockerHubCreds')
        DOCKER_IMAGE = 'ronaldjrombao/comp367lab3:latest'
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
                script {
                    dockerImage = docker.build("ronaldjrombao/comp367lab3:latest")
                }
            }
        }
       stage('Test Image') {
            steps {
                sh 'docker run --rm ronaldjrombao/comp367lab3:latest ./run-tests.sh'
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