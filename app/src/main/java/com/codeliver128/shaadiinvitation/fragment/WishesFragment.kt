package com.codeliver128.shaadiinvitation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.codeliver128.shaadiinvitation.R
import com.codeliver128.shaadiinvitation.WishesModel
import com.codeliver128.shaadiinvitation.adapters.WishesAdapter
import java.util.ArrayList

class WishesFragment : Fragment() {

    private lateinit var rv_wishes: RecyclerView
    private lateinit var wishesAdapter: WishesAdapter
    private var wishesList = ArrayList<WishesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.wishes_fragment, container, false)
        rv_wishes = view.findViewById<RecyclerView>(R.id.rv_wishes)
        var layoutManager: androidx.recyclerview.widget.LinearLayoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(context);
        rv_wishes.layoutManager = layoutManager

        wishesList.clear();

        val wish1 = WishesModel()
        wish1.message =
            "Congratulations on this big day! We are honored to be a part of this special occasion and watch the blossoming love between our two special friends transcend to eternity. May your love and commitment for one another deepen and grow stronger with each passing day."
        wish1.name = "Raj"
        wish1.photo_id = R.drawable.baby

        val wish5 = WishesModel()
        wish5.message =
            "Congratulations on your special day! From now on you will never be alone, cause your spouse will be always near you both in good and in bad times. May God bless you with endless love!"
        wish5.name = "Kailash Khuranna"
        wish5.photo_id = R.drawable.raj

        val wish7 = WishesModel()
        wish7.message =
            "Marriage is about finding true love and sharing a common, beautiful dream. Congrats on the find, and here's to making that dream come to life!"
        wish7.name = "Laxman Singh"
        wish7.photo_id = R.drawable.profile

        val wish2 = WishesModel()
        wish2.message =
            "Your wedding day will come and go, but may your love forever grow."
        wish2.name = "Anjani"
        wish2.photo_id = R.drawable.profile

        val wish4 = WishesModel()
        wish4.message =
            "May the years ahead be filled with lasting joy."
        wish4.name = "Upasna"
        wish4.photo_id = R.drawable.profile

        val wish3 = WishesModel()
        wish3.message =
            "Best wishes on this wonderful journey, as you build your new lives together."
        wish3.name = "Sushant"
        wish3.photo_id = R.drawable.profile

        val wish6 = WishesModel()
        wish6.message =
            "Wishing you both a lifetime of love and happiness."
        wish6.name = "Harshita"
        wish6.photo_id = R.drawable.profile

        val wish12 = WishesModel()
        wish12.message =
            "Let the spark in your eyes stay forever and may this auspicious bonding be blessed by the Almighty."
        wish12.name = "Ishan"
        wish12.photo_id = R.drawable.profile

        val wish13 = WishesModel()
        wish13.message =
            "Let this occasion mark the start of another journey. May the life ahead be a cheerful one with love, happiness, excitement, joy and peace. May this everlasting love be like that of a crown jewel which will tie all the bonds together. Hearty wishes to the loveliest couple."
        wish13.name = "Ankit"
        wish13.photo_id = R.drawable.profile


        val wish8 = WishesModel()
        wish8.message =
            "Marriage is a promising bond that also embarks a journey towards the end of time. Here’s wishing you both a pleasant and memorable ride ahead."
        wish8.name = "Sonal "
        wish8.photo_id = R.drawable.profile

        val wish9 = WishesModel()
        wish9.message =
            "I wish that all the days ahead be as happy as this day with many more reasons to celebrate a lifetime of happiness and love."
        wish9.name = "Neha "
        wish9.photo_id = R.drawable.profile


        val wish11 = WishesModel()
        wish11.message =
            "Thanks for inviting us to eat and drink while you get married. Congrats!"
        wish11.name = "Rahul"
        wish11.photo_id = R.drawable.profile

        val wish15 = WishesModel()
        wish15.message =
            "As you are all set to move into a new life by holding each other’s love in your heart and vows of passion, commitment, love and loyalty. We wish that the journey ahead be joyous as this day."
        wish15.name = "Naveen"
        wish15.photo_id = R.drawable.profile

        val wish10 = WishesModel()
        wish10.message =
            "My heartfelt wishes on your wedding day. May the bond that you share last forever and let it never change and grow firmer and deeper day by day. Have a great married life!"
        wish10.name = "Prashant"
        wish10.photo_id = R.drawable.profile


        val wish14 = WishesModel()
        wish14.message =
            "My heartfelt wishes on your wedding day. May the bond that you share last forever and let it never change and grow firmer and deeper day by day. Have a great married life!"
        wish14.name = "Niraj"
        wish14.photo_id = R.drawable.profile


        wishesList.add(wish1)
        wishesList.add(wish5)
        wishesList.add(wish7)
        wishesList.add(wish8)
        wishesList.add(wish3)
        wishesList.add(wish2)
        wishesList.add(wish4)
        wishesList.add(wish15)
        wishesList.add(wish13)
        wishesList.add(wish9)
        wishesList.add(wish11)
        wishesList.add(wish12)
        wishesList.add(wish10)
        wishesList.add(wish6)
        wishesList.add(wish14)

        wishesAdapter = WishesAdapter(activity as Context, wishesList)

        rv_wishes.setAdapter(wishesAdapter)

        return view
    }


}

