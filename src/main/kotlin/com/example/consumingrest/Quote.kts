package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Quote(type: String, value: Value) {

    override fun toString(): String? {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}'
    }
}