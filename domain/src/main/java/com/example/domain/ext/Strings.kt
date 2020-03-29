package com.example.domain.ext

import java.util.regex.Pattern.compile

private val emailRegex = compile(
    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"
)

private val phoneRegex = compile(
    "^[+]?[0-9]{10,13}$"
)

private val zipCodeRegex = compile(
    "(^\\d{5}-\\d{3}|^\\d{2}.\\d{3}-\\d{3}|\\d{8})"
)

@JvmName("isEmail")
fun String.isEmail(): Boolean {
    return emailRegex.matcher(this).matches()
}

@JvmName("isPhone")
fun String.isPhone(): Boolean {
    return phoneRegex.matcher(this).matches()
}

@JvmName("isCnpj")
fun String.isCnpj(): Boolean {
    val str = this.replace("-", "").replace("/","").replace(".","")
    var calc: Int
    var num = 5
    var sum = 0
    for(x in 0..11) {
        calc = str[x].toString().toInt() * num
        sum += calc
        --num
        if(num == 1) num = 9
    }
    var rest = sum % 11
    var test = 11 - rest
    if(test < 2) test = 0
    if(test != str[12].toString().toInt()) return false
    num = 6
    sum = 0
    for(x in 0..12) {
        calc = str[x].toString().toInt() * num
        sum += calc
        --num
        if(num == 1) num = 9
    }
    rest = sum % 11
    test = 11 - rest
    if(test < 2) test = 0
    if(test != str[13].toString().toInt()) return false
    return true
}

@JvmName("isAddressPostal")
fun String.isAddressPostal(): Boolean {
    return zipCodeRegex.matcher(this).matches()
}