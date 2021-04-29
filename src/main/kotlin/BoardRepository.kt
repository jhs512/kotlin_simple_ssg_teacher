class BoardRepository {
    val boards = mutableListOf(
        Board(1, Util.getNowDateStr(), Util.getNowDateStr(), "공지", "notice"),
        Board(2, Util.getNowDateStr(), Util.getNowDateStr(), "자유", "free")
    )

    fun getFilteredBoards(): List<Board> {
        return boards
    }
}