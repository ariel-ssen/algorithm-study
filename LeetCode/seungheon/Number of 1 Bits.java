class Solution {
    int cnt = 0;

    void dc(int n) {
        if (n == 0) return;

        if (n % 2 != 0) cnt++;

        dc(n / 2);
    }

    public int hammingWeight(int n) {
        dc(n);

        return cnt;
    }
}
