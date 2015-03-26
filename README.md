
RSS XML Generator
=================

Generate an XML document for an RSS feed.

 - Current version: 1.0.0-SNAPSHOT
 - Released: ?? ??? ????


Requirements
------------

 - Java 7
 - Thymeleaf 2.1 (2.1.4 and its dependencies included)


Installation
------------

### Standalone distribution
Copy the JAR from [the latest release bundle](https://github.com/ultraq/rss-xml-generator/releases),
placing it in the classpath of your program, or build the project from the
source code here on GitHub.

### For Maven and Maven-compatible dependency managers
Add a dependency to your project with the following co-ordinates:

 - GroupId: `nz.net.ultraq.rss`
 - ArtifactId: `rss-xml-generator`
 - Version: `1.0.0-SNAPSHOT`


Usage
-----

Create an instance of the `RssXmlGenerator` for every RSS Channel you wish to
serve.

```groovy
RssXmlGenerator rssXmlGenerator = new RssXmlGenerator(
  channel: new Channel(
    title:        'My Website News and Updates',
    link:         'http://www.mywebsite.com/',
    description:  'All of the latest stuff from My Website',
    atomSelfLink: 'http://www.mywebsite.com/rss/',
    image: new Image(
      url:   'http://www.mywebsite.com/images/website-icon.png',
      title: 'My Website',
      link:  'http://www.mywebsite.com/'
    )
  )
)
```

Then, whenever you wish to generate an RSS XML document, call the `generate`
method, passing in the channel items you wish to have generated at this time,
and a `Writer` to output the document to.

```groovy
def items = new ArrayList<Item>()
items.push(new Item(
  title:       'Item 1',
  link:        'http://www.mywebsite.com/item-1/',
  description: 'A long time ago, in a galaxy far far away...'  
))

rssXmlGenerator.generate(items, response.writer)
```

> The example code above populates the minimum fields required by RSS.  There
> are plenty more properties in the Channel, Image, and Item.  Check out
> [the RSS spec](http://www.rssboard.org/rss-specification) for all the
> available properties.


Changelog
---------

### 1.0.0
 - Initial release

