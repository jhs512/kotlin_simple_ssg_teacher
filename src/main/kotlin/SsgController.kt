class SsgController {
    fun build(rq: Rq) {
        val articles = articleRepository.getArticles()

        for ( article in articles ) {
            val fileContent = "메롱"

            val fileName = "article_detail_${article.id}.html"
            writeStrFile("ext/article_detail_${article.id}.html", fileContent)
            println(fileName + "파일이 생성되었습니다.")
        }

        // article_list_notice.html
        // article_list_free.html

        // article_detail_1.html
        // ..
        // article_detail_20.html
    }
}