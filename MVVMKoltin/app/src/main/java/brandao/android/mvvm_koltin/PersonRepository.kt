package brandao.android.mvvm_koltin

class PersonRepository {
    fun login(email: String, passaword: String): Boolean{

        return (email != "" && passaword != "")

    }
}