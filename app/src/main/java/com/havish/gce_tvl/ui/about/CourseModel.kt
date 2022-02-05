package com.havish.gce_tvl.ui.about

data class CourseModel(var img:Int) {

    lateinit var title: String
    lateinit var description: String
    constructor( img: Int,title:String,description:String) : this(img) {
        this.img=img
        this.title=title
        this.description=description
    }
}