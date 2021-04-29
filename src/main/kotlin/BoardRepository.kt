class BoardRepository {
    val boards = mutableListOf(
        Board(1, Util.getNowDateStr(), Util.getNowDateStr(), "공지", "notice"),
        Board(2, Util.getNowDateStr(), Util.getNowDateStr(), "자유", "free")
    )

    /*
    @JvmName("getBoards1")
    fun getBoards(): MutableList<Board> {
        return boards
    }
    */

    fun getFilteredBoards(): List<Board> {
        return boards
    }
}