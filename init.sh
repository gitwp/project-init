#!/bin/bash

scriptPath=`pwd`
targetPath=/e/MyGit/test/jersey-test/

sh init-gradle-dir.sh $targetPath


sh $scriptPath/init-git.sh $targetPath