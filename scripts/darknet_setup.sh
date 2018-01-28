#!/bin/bash

# Clone submodule
git submodule update --init --recursive

# Download weights
mkdir ../thirdparty/darknet/weight
cd ../thirdparty/darknet/weight
wget https://pjreddie.com/media/files/yolo.weights

cd ..
make

echo "Now from the darknet directory, run: "
echo "./darknet detect cfg/yolo.cfg weight/yolo.weights data/dog.jpg"
