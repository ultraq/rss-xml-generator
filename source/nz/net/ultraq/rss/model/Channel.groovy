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

package nz.net.ultraq.rss.model

import groovy.transform.Canonical
import java.time.ZonedDateTime

/**
 * Representation of the largely static parts of an RSS channel.
 * 
 * @author Emanuel Rabina
 */
@Canonical
class Channel {

	// Required fields
	String title
	String link
	String description

	// Fields from other namespaces
	String atomSelfLink

	// Optional fields
	String language
	String copyright
//	String managingEditor // TODO
//	String webMaster      // TODO
	ZonedDateTime pubDate
	ZonedDateTime lastBuildDate
//	Category[] categories // TODO
//	String generator      // NOTE: Hardcoded
//	String docs           // NOTE: Hardcoded
//	Cloud cloud           // TODO
	int ttl
	Image image
//	Rating rating         // NOTE: No longer relevant?
//	TextInput textInput   // NOTE: no longer relevant?
//	SkipHour[] skipHours  // TODO
//	SkipDay[] skipDays    // TODO
	Item[] items
}
