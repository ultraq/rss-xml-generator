
Changelog
=========

### 3.3.0
 - Upgraded Groovy to 4.0.0
 - The `javadoc` artifact in Maven downloads now includes this project's
   groovydocs, which have been missing thus far

### 3.2.0
 - Upgrade Groovy to 3.0.8
 - Upgrade If-Not-Null dialect to 4.0.0
 - Upgrade Thymeleaf to 3.0.12

### 3.1.1
 - Fix generated POM - Groovy is needed as a compile dependency

### 3.1.0
 - Upgrade Groovy to 3.0.3
 - Upgrade If-Not-Null dialect to 3.0.0

### 3.0.0
 - Drop support for Java 7
   ([#2](https://github.com/ultraq/rss-xml-generator/issues/2))
 - Swap Joda time for java.time
   ([#3](https://github.com/ultraq/rss-xml-generator/issues/3))

### 2.1.0
 - Change RSS template to use, and thus output, Unix line ends
 - Update to Groovy 2.4.7
 - Update to thymeleaf-ifnotnull-dialect 2.1.0
 - Added unit tests, codenarc rules, project now verifiable w/ Travis CI

### 2.0.0
 - Updated to use Thymeleaf 3
 - Change `RssXmlGenerator.generate()` method to accept just the channel and
   output - items to publish are now part of the channel.

### 1.0.0
 - Initial release
