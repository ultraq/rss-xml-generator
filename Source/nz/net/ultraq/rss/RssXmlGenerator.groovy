/* 
 * Copyright 2015, Emanuel Rabina (http://www.ultraq.net.nz/)
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

package nz.net.ultraq.rss

import nz.net.ultraq.rss.model.Channel
import nz.net.ultraq.rss.model.Item
import nz.net.ultraq.thymeleaf.JodaDialect
import org.joda.time.DateTime
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

import groovy.transform.Immutable

/**
 * Class to generate an RSS XML document using a Thymeleaf template.
 * 
 * @author Emanuel Rabina
 */
@Immutable
class RssXmlGenerator {

	private static final TemplateEngine templateEngine

	private Channel channel

	/**
	 * Initialize a new Thymeleaf template engine for the generator.
	 */
	static {
		templateEngine = new TemplateEngine(
			templateResolver: new ClassLoaderTemplateResolver(
				templateMode:      'XML',
				prefix:            'nz/net/ultraq/rss/',
				characterEncoding: 'UTF-8'
			),
			additionalDialects: [
				new JodaDialect(),
				new RssDialect()
			]
		)
	}

	/**
	 * Generate an RSS XML document with the following items.
	 * 
	 * @param items  List of items to include in the feed.
	 * @param writer Output channel to write the XML document to.
	 */
	void generate(List<Item> items, Writer writer) {

		// Ensure items sorted from latest to oldest
		def sortedItems = items.sort({ item1, item2 ->
			return item2.pubDate <=> item1.pubDate
		})

		templateEngine.process('Template.xml', new Context(
			variables: [
				channel:       channel,
				items:         sortedItems,
				pubDate:       sortedItems.first().pubDate,	// TODO: Allow passed-in publication date?
				lastBuildDate: new DateTime()
			]
		), writer)
	}
}
