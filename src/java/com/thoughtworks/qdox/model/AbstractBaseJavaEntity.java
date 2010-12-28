package com.thoughtworks.qdox.model;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AbstractBaseJavaEntity implements Serializable {

	private String name;
	private List<Annotation> annotations = Collections.emptyList();
	private int lineNumber = -1;
	protected String comment;
	protected List<DocletTag> tags = new LinkedList<DocletTag>();

	public AbstractBaseJavaEntity() {
		super();
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public String getName() {
	    return name;
	}

	public List<Annotation> getAnnotations() {
	    return annotations;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public void setAnnotations(List<Annotation> annotations) {
	    this.annotations = annotations;
	}

	public void setLineNumber(int lineNumber) {
	    this.lineNumber = lineNumber;
	}

	/**
	 * Not every entity has a parentClass, but AnnotationFieldRef requires access to it.
	 * When used with JavaClass, don't confuse this with getSuperClass()
	 * 
	 * @return the surrounding class
	 */
	public JavaClass getParentClass() { return null; }

	public String getComment() {
	    return comment;
	}

	public void setComment(String comment) {
	    this.comment = comment;
	}

	public List<DocletTag> getTags() {
	    return tags;
	}

	public List<DocletTag> getTagsByName(String name) {
	    List<DocletTag> specifiedTags = new LinkedList<DocletTag>();
	    for ( DocletTag docletTag : tags ) {
	        if (docletTag.getName().equals(name)) {
	            specifiedTags.add(docletTag);
	        }
	    }
	    return specifiedTags;
	}

	public DocletTag getTagByName(String name) {
	    for (DocletTag docletTag : tags) {
	        if (docletTag.getName().equals(name)) {
	            return docletTag;
	        }
	    }
	    return null;
	}

	/**
	 * Convenience method for <code>getTagByName(String).getNamedParameter(String)</code>
	 * that also checks for null tag.
	 * @since 1.3
	 */
	public String getNamedParameter(String tagName, String parameterName) {
	    DocletTag tag = getTagByName(tagName);
	    if(tag != null) {
	        return tag.getNamedParameter(parameterName);
	    } else {
	        return null;
	    }
	}

	public void setTags(List<DocletTag> tagList) {
	    this.tags = tagList;
	}

}