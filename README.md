
RSS XML Generator
=================

[![Build Status](https://github.com/ultraq/rss-xml-generator/actions/workflows/build.yml/badge.svg)](https://github.com/ultraq/rss-xml-generator/actions)
[![Coverage Status](https://coveralls.io/repos/github/ultraq/rss-xml-generator/badge.svg?branch=main)](https://coveralls.io/github/ultraq/rss-xml-generator?branch=main)
[![Maven Central](https://img.shields.io/maven-central/v/nz.net.ultraq.rss/rss-xml-generator.svg?maxAge=3600)](http://search.maven.org/#search|ga|1|g%3A%22nz.net.ultraq.rss%22%20AND%20a%3A%22rss-xml-generator%22)

Generate an XML document for an RSS feed.


Installation
------------

Minimum of Java 8 required.

### For Maven and Maven-compatible dependency managers

Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.rss`
 - ArtifactId: `rss-xml-generator`
 - Version: `3.1.1`

Check the [project releases](https://github.com/ultraq/rss-xml-generator/releases)
for a list of available versions.  Each release page also includes a
downloadable JAR if you want to manually add it to your project classpath.


Usage
-----

Create an instance of the `RssXmlGenerator`.  Then, whenever you need to create
an RSS feed, provide a `Channel` (describes the RSS channel and its publishable
items) to the `generate` method.  You'll also need a `Writer` so that the
generated XML has somewhere to go to.

```groovy
def channel = new Channel(
  title:       'My Website News and Updates',
  link:        'http://www.mywebsite.com/',
  description: 'All of the latest stuff from My Website',
  image: new Image(
    url:   'http://www.mywebsite.com/images/website-icon.png',
    title: 'My Website News and Updates',
    link:  'http://www.mywebsite.com/'
  ),
  items: [
     new Item(
       title: 'My awesome blog post',
       link:  'http://www.mywebsite.com/blog/awesome'
     ),
     ...
   ]
)
def output = new StringWriter()

def rssXmlGenerator = new RssXmlGenerator()
rssXmlGenerator.generate(channel, output)
```

> The example code above populates the minimum fields required by RSS.  There
> are plenty more properties in the Channel, Image, and Item objects.  Check out
> [the RSS spec](http://www.rssboard.org/rss-specification) for all the
> available properties.
