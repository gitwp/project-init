#!/bin/bash

echo "init-gradle-dir start..."
cd $1
mkdir -p src/main/java/com/wangp/jersey
mkdir -p src/main/resources
mkdir -p src/main/webapp/WEB-INF
mkdir -p src/test/java
mkdir -p src/test/resources

cd -
cp -r src $1
cp build.gradle $1

cd $1
mv src/main/java/com/wangp/stock/* src/main/java/com/wangp/jersey/
rm -rf src/main/java/com/wangp/stock
mv src/main/resources/stock-app.properties src/main/resources/jersey-test.properties
mv src/main/resources/stock-app-env.properties src/main/resources/jersey-test-env.properties

sed -i 's/stock-app/jersey-test/g' build.gradle
sed -i 's/stock-app/jersey-test/g' src/main/resources/spring/applicationContext.xml
sed -i 's/stock/jersey/g' src/main/resources/spring/applicationContext.xml
sed -i 's/stock/jersey/g' src/main/resources/mybatis/mybatis-config.xml
sed -i 's/stock/jersey/g' src/main/resources/mybatis/datasource.xml
sed -i 's/stock/jersey/g' src/main/resources/jersey-test.properties
sed -i 's/STOCK/JERSEY/g' src/main/resources/jersey-test.properties
sed -i 's/STOCK/JERSEY/g' src/main/resources/jersey-test-env.properties

function fSum()
{
   echo "file:"+$1
   filelist=`ls $1`
   for file in $filelist
   do
      echo "file:"+$file
      if [ -f "$file" ]; then
        sed -i 's/com.wangp.stock/com.wangp.jersey/g' $file
      else
        fSum $1/$file
      fi
   done
}

fSum src/main/java/com/wangp

echo "init-gradle-dir end..."
