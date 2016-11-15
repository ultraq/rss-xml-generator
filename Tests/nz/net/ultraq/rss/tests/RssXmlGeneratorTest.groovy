/* 
 * Copyright 2016, Emanuel Rabina (http://www.ultraq.net.nz/)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nz.net.ultraq.rss.tests

import nz.net.ultraq.rss.RssXmlGenerator
import nz.net.ultraq.rss.model.Channel
import nz.net.ultraq.rss.model.Image
import nz.net.ultraq.rss.model.Item

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.junit.Test

/**
 * Tests for the overall output of the RSS XML Generator.
 * 
 * @author Emanuel Rabina
 */
class RssXmlGeneratorTest {

	/**
	 * Basic string comparison of the resulting XML.
	 */
	@Test
	void testOutputMatches() {

		def channel = new Channel(
			title:         'My Website News and Updates',
			link:          'http://www.mywebsite.com/',
			description:   'All of the latest stuff from My Website',
			atomSelfLink:  'http://www.mywebsite.com/rss',
			language:      'en',
			copyright:     '2016',
			pubDate:       new DateTime(2016, 1, 1, 0, 0, 0, DateTimeZone.UTC),
			lastBuildDate: new DateTime(2016, 1, 1, 0, 0, 0, DateTimeZone.UTC),
			ttl:           360,
			image: new Image(
				url:   'http://www.mywebsite.com/images/website-icon.png',
				title: 'My Website News and Updates',
				link:  'http://www.mywebsite.com/'
			),
			items: [
				new Item(
					title:       'My awesome blog post',
					link:        'http://www.mywebsite.com/blog/awesome',
					dcCreator:   'Yours truly',
					description: 'This post will blow your mind!',
					guid:        'http://www.mywebsite.com/blog/awesome',
					pubDate:     new DateTime(2016, 1, 2, 0, 0, 0, DateTimeZone.UTC)
				)
			]
		)
		def stringWriter = new StringWriter()

		def rssXmlGenerator = new RssXmlGenerator()
		rssXmlGenerator.generate(channel, stringWriter)

		def result = stringWriter.toString()
		def expected = new File(this.class.getResource('RssXmlGeneratorTest-Expected.xml').toURI()).text
		assert result == expected
	}
}
