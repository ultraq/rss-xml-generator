
RSS XML Generator
=================

Generate an XML document for an RSS feed.

 - Current version: 1.0.0
 - Released: 29 March 2013


Installation
------------

Minimum of Java 7 required.

### Standalone distribution
Copy the JAR from [the latest release bundle](https://github.com/ultraq/rss-xml-generator/releases),
placing it in the classpath of your program, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.rss`
 - ArtifactId: `rss-xml-generator`
 - Version: `1.0.0`


Usage
-----

Create an instance of the `RssXmlGenerator`.  Then, whenever you need to create
an RSS feed, provide a `Channel` (describes the RSS channel) and list of `Item`s
(describes the things to publish) to the `generate` method.  You'll also need a
`Writer` so that the generated XML has somewhere to go to.

```groovy
def channel = new Channel(
  title:       'My Website News and Updates',
  link:        'http://www.mywebsite.com/',
  description: 'All of the latest stuff from My Website',
  image: new Image(
    url:   'http://www.mywebsite.com/images/website-icon.png',
    title: 'My Website News and Updates',
    link:  'http://www.mywebsite.com/'
  )
)
def items = [
  new Item(
    title: 'My awesome blog post',
    link:  'http://www.mywebsite.com/blog/awesome'
  ),
  ...
]
def output = new StringWriter()

def rssXmlGenerator = new RssXmlGenerator()
rssXmlGenerator.generate(channel, items, output)
```

> The example code above populates the minimum fields required by RSS.  There
> are plenty more properties in the Channel, Image, and Item objects.  Check out
> [the RSS spec](http://www.rssboard.org/rss-specification) for all the
> available properties.


Changelog
---------

### 1.0.0
 - Initial release

