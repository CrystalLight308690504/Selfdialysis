/*格式化字符串*/
String.prototype.trim = function () {
    return this.triml().trimr();
}

String.prototype.triml = function () {
    return this.replace(/^[\s\n\t]+/g, "");
}

String.prototype.trimr = function () {
    return this.replace(/[\s\n\t]+$/g, "");
}