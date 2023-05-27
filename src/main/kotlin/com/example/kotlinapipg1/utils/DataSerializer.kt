package com.example.kotlinapipg1.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.util.StdDateFormat
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer


class DataSerializer : Serializer<Any?> {
    override fun serialize(topic: String, data: Any?): ByteArray? {
        if (data == null) return null
        val utils = Utils()
        return utils.jsonMapper().writeValueAsBytes(data)
    }

    override fun close() {}
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}

class DataDeserializer : Deserializer<Any?> {
    override fun deserialize(topic: String, data: ByteArray?): Any? {
        if (data == null) return null
        val utils = Utils()
        return utils.jsonMapper().readValue(data, Any::class.java)
    }

    override fun close() {}
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}

class Utils {
    fun jsonMapper() = ObjectMapper().apply {
        registerKotlinModule()
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        dateFormat = StdDateFormat()
    }
}
