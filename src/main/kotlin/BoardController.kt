class BoardController {
    fun list(rq: Rq) {
        println("번호 / 생성날짜 / 이름 / 코드")

        val boards = boardRepository.getFilteredBoards()

        for (board in boards) {
            println("${board.id} / ${board.regDate} / ${board.name} / ${board.code}")
        }
    }
}