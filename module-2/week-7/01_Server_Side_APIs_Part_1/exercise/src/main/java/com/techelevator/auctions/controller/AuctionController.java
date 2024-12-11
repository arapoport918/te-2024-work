package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auctions") //every method following this automatically includes this
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(name = "title_like", defaultValue = "") String title_like,
                              @RequestParam(name = "currentBid_lte", defaultValue = "0") double currentBid_lte) {
        try {

            if (title_like != null && currentBid_lte > 0) {
                return auctionDao.getAuctionsByTitleAndMaxBid(title_like, currentBid_lte);
            }

            if (currentBid_lte > 0) {
                return auctionDao.getAuctionsByMaxBid(currentBid_lte);
            }

            if (title_like != null) {
                return auctionDao.getAuctionsByTitle(title_like);
            }

            return auctionDao.getAuctions();
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        }
        return null;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        try {
            return auctionDao.getAuctionById(id);
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        }
        return null;
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Auction create(@RequestBody Auction newAuction) {
        try {
            return auctionDao.createAuction(newAuction);
        } catch (ResourceAccessException e) {
            System.out.println(e.getMessage());
        } catch (RestClientResponseException e) {
            System.out.println(e.getRawStatusCode());
        }
        return null;
    }

}
