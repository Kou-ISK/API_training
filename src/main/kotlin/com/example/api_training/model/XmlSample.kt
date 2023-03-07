package com.example.api_training.model

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty

data class XmlSample(
    @get:JacksonXmlElementWrapper(localName = "itemNum")
    @get:JacksonXmlProperty(localName = "itemNum")
    var itemNum: Int = 1,
    @get:JacksonXmlElementWrapper(localName = "itemName")
    @get:JacksonXmlProperty(localName = "itemName")
    var itemName: String = "item"
)