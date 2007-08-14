/* 
 * Copyright 2007 Luke Daley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
templates {
	t1 {
		contextSource {
			url = "ldap://example.com"
			base = "ou=example,dc=com"
		}
		base = "ou=people"
	}
	t2 {
		contextSource {
			url = "ldap://example2.com"
			base = "ou=example2,dc=com"
		}
		base = "ou=people2"
	}
}
defaultTemplate = "t1"
schemas = [gldapo.schema.provided.Person, gldapo.schema.provided.ActiveDirectoryPerson]

environments {
	dev {
		templates.t2.base = "development"
	}
}