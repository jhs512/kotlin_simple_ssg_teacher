class SsgController {
    fun build(rq: Rq) {
        println("= 게시물 상세페이지 생성 시작 =")
        makeArticleDetailPages()
        println("= 게시물 상세페이지 생성 끝 =")

        println("= 게시물 리스트페이지 생성 시작 =")
        makeArticleListPages()
        println("= 게시물 리스트페이지 생성 끝 =")
    }

    private fun makeArticleListPages() {
        val boards = boardRepository.getBoards()

        for (board in boards) {
            makeArticleListPage(board)
        }
    }

    private fun makeArticleListPage(board: Board) {
        val articles = articleRepository.getArticles()

        var fileContent = "<meta charset=\"UTF-8\">\n"

        fileContent += "<h1>${board.name} 게시물 리스트</h1>\n"

        for (article in articles) {

            if (article.boardId == board.id) {

                val writer = memberRepository.getMemberById(article.memberId)!!
                val writerName = writer.nickname

                fileContent += "<div>"

                val detailPageUri = "article_detail_${article.id}.html"

                fileContent += "<a href=\"$detailPageUri\">"

                fileContent += "번호 : ${article.id}"
                fileContent += " / 작성날자 : ${article.regDate}"
                fileContent += " / 작성자 : $writerName"
                fileContent += " / 제목 : ${article.title}"

                fileContent += "</a>"

                fileContent += "<div>\n"
            }
        }

        val fileName = "article_list_${board.code}.html"
        writeStrFile("ext/${fileName}", fileContent)
        println(fileName + "파일이 생성되었습니다.")
    }

    private fun makeArticleDetailPages() {
        // 모든 게시물 불러오기
        val articles = articleRepository.getArticles()

        for (article in articles) {
            makeArticleDetailPage(article)
        }
    }

    private fun makeArticleDetailPage(article: Article) {
        val board = boardRepository.getBoardById(article.boardId)!!
        val writer = memberRepository.getMemberById(article.memberId)!!

        val boardName = board.name
        val writerName = writer.nickname

        var fileContent = "<meta charset=\"UTF-8\">\n"

        fileContent += "<h1>${article.id}번 게시물</h1>\n"

        fileContent += "<div>번호 : ${article.id}</div>\n"
        fileContent += "<div>작성날짜 : ${article.regDate}</div>\n"
        fileContent += "<div>수정날짜 : ${article.updateDate}</div>\n"
        fileContent += "<div>게시물 종류 : ${boardName}</div>\n"
        fileContent += "<div>작성자 : ${writerName}</div>\n"
        fileContent += "<div>제목 : ${article.title}</div>\n"
        fileContent += "<div>내용 : ${article.body}</div>\n"
        fileContent += "<div><a href=\"#\" onclick=\"history.back();\">뒤로가기</a></div>\n"

        val fileName = "article_detail_${article.id}.html"
        writeStrFile("ext/${fileName}", fileContent)
        println(fileName + "파일이 생성되었습니다.")
    }
}