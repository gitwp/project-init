#!/bin/bash

echo "init-git start..."

cd $1

touch .gitignore
echo -e \
"*.class \n\
\n\
# Mobile Tools for Java (J2ME)\n\
.mtj.tmp/\n\
\n\
# Package Files #\n\
*.jar\n\
*.war\n\
*.ear\n\
\n\
# build files\n\
out/\n\
*.iml\n\
*.ipr\n\
*.iws\n\
.gradle/\n\
build/\n\
# virtual machine crash logs, see http://www.java.com/en/download/help/error_hotspot.xml\n\
hs_err_pid*\n\
\n\
#idea project\n\
.idea\n\
.idea/*\n\
*.iml\n\
\n\
#logs\n\
logs/\n\
" \
> .gitignore

git init
git add .
git commit -m 'init git store'

echo "init-git end..."