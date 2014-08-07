# SCAPE Platform Datamodel

Datamodel for the SCAPE platform

### SCAPE Data transfer objects

This is the implementation of the Scape Digital Object Model, for exchanging data in the SCAPE platform. It is built on top of various metadata standards like textmd, NISO/MIX and PREMIS.

                +-----------------------+
                |  Intellectual Entity  |
                +-----------------------+
                1/                    \1
                /                      \
              1/                        \*
     +--------------+            +------------------+
     |   Desc. MD   |            |  Representation  |
     +--------------+            +------------------+
                                 1/                \1
                                 /                  \
                               1/                    \*
                       +-----------------+      +----------+
                       |  Adm. Metadata  |      |   File   |
                       +-----------------+      +----------+
                                                          \1
                                                           \
                                                            \*
                                                       +-------------+
                                                       |  Bitstream  |
                                                       +-------------+



### What does SCAPE Platform Datamodel do?

It's a the datamodel for the SCAPE platform

### What are the benefits for end user?

A list of benefits X brings to the end user:

* The user can handle SCAPE Objects 

### Who is intended audience?

* Developers implementing SCAPE features

## Features and roadmap

### Version 0.1.6

* Java objects fro SCAPE
* Serialization/Deserialization for SCAPE objects

### How to install and use

#### Immutability & Builders
All objects are immutable and are constructed using their respective inner Builder classes, and allow for method chaining.

```Java
IntellectualEntity entity = new IntellectualEntity.Builder()
	.identifier(new Identifier("minimal-1"))
    .descriptive(TestUtil.createMinimalDC())
    .build();
```

#### Deep Copying
All copies should be deep copy for thread safety issues.

In order to get a copy of an Object you can either create a new Builder from it's respective outer class,
or employ the Utility class CopyUtil to get a plain deep copy without the Builder:

```Java
IntellectualEntity orig = new IntellectualEntity.Builder()
	.identifier(new Identifier("minimal-1"))
    .descriptive(TestUtil.createMinimalDC())
    .build();
```

```Java
IntellectualEntity copy1=new IntellectualEntity.Builder(orig)
	.identifier(new Identifier("copy-1"))
	.build();
```

```Java
IntellectualEntity copy2 = CopyUtil.deepCopy(IntellectualEntity.class, orig);			
```

#### Serialization/Deserialization
An example for serialization of an Intellectual Entity into it's METS representation looks like this:

```Java
IntellectualEntity entity = TestUtil.createRandomEntity();
SCAPEMarshaller.getInstance().serialize(entity, System.out);
```        

An example for deseriialization looks like this:

```Java
InputStream in = new FileInputStream("entity-1.xml");
IntellectualEntity deserialized=SCAPEMarshaller.getInstance().deserialize(IntellectualEntity.class, in);
```
		
#### Base path and encapsulated directory settings for ONBConverter

Since the file paths at the austrian national library are created using a provided Pairtree parser two additional properties are exposed for parsing files from the ONB:


* _scape.onb.pairtree.basepath_ The base path where the files at ONB are located
```Java
JAVA_OPTS="$JAVA_OPTS -Dscape.onb.pairtree.basepath=/tmp/scape/onb"
```

* _scape.onb.pairtree.encapsulated_ The encapsulated directory of the path
```Java
JAVA_OPTS="$JAVA_OPTS -Dscape.onb.pairtree.encapsulated=onb"
```


### Roadmap

* finished

### Licence

SCAPE Platform Datamodel is released under [Apache version 2.0 license](LICENSE.txt).

### Acknowledgements

Part of this work was supported by the European Union in the 7th Framework Program, IST, through the SCAPE project, Contract 270137.

### Support

This tool is supported by the [Open Planets Foundation](http://www.openplanetsfoundation.org). Commercial support is provided by company X.

## Develop

[![Build Status](https://travis-ci.org/openplanets/scape.png)](https://travis-ci.org/openplanets/scape-platform-datamodel)

### Requirements

To build you require:

* Git client
* Apache Maven
* Java Developers Kit (e.g. OpenJDK 6)
* Dependency to paitree

Updating the ONB converter introduced a dependency to gov.loc.pairtree:1.1.1 This is not available on maven central! So you will have to install it manually in your local maven repository:

```bash
wget http://downloads.sourceforge.net/project/loc-xferutils/loc-pairtree-java-library/pairtree-1.1.1.jar?r=http%3A%2F%2Fsourceforge.net%2Fprojects%2Floc-xferutils%2Ffiles%2Floc-pairtree-java-library%2F&ts=1384173580&use_mirror=heanet

mvn install:install-file -Dfile=/path/to/pairtree-1.1.1.jar -DartifactId=pairtree -Dversion=1.1.1 -DgroupId=gov.loc -Dpackaging=jar
```

### Build

To compile go to the sources folder and execute the command:

```bash
$ mvn clean install
```


### Contribute

1. [Fork the GitHub project](https://help.github.com/articles/fork-a-repo)
2. Change the code and push into the forked project
3. [Submit a pull request](https://help.github.com/articles/using-pull-requests)

To increase the changes of you code being accepted and merged into the official source here's a checklist of things to go over before submitting a contribution. For example:

* Has unit tests (that covers at least 80% of the code)
* Has documentation (at least 80% of public API)
* Agrees to contributor license agreement, certifying that any contributed code is original work and that the copyright is turned over to the project




                                              
