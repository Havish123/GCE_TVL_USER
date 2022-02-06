package com.havish.gce_tvl.ebook

class EbookData() {

    lateinit var pdfUrl: String
    lateinit var pdfTitle: String

    constructor(pdfTitle:String,pdfUrl:String):this(){
        this.pdfTitle=pdfTitle
        this.pdfUrl=pdfUrl
    }
}