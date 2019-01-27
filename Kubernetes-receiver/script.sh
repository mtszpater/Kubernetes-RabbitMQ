sudo docker build -t gcr.io/[project-name]/rabbitmq-receiver .
gcloud auth print-access-token | sudo docker login -u oauth2accesstoken --password-stdin https://gcr.io
sudo docker push gcr.io/[project-name]/rabbitmq-receiver
