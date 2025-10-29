class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            high = (high < piles[i]) ? piles[i] : high;
        }
        
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (canEat(piles, h, mid)){
                high = mid - 1 ;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canEat(int[] piles, int h, int k){
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            time += (piles[i] + k - 1) / k;
            if (time > h) return false;
        }
        return time <= h;
    }
}
